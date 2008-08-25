package cn.org.pomer.flex.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import cn.org.pomer.demo.entity.Student;

/**
 * 将entiy bean class 转换成actionscript 3 类
 * 
 * @author linlinyu
 * 
 */
public class JavaBeanToAs {
	private String outPath = "C:\\as\\";
	private boolean override = false;
	private boolean generateAssociateClass = false;

	private Map<String, String> generated = new HashMap<String, String>();

	public static void main(String[] args) {
		JavaBeanToAs javaBeanToAs = new JavaBeanToAs();
		javaBeanToAs.setOverride(false);
		javaBeanToAs.setGenerateAssociateClass(false);
		javaBeanToAs.generateAsFile(Student.class);

	}

	/**
	 * 将指定的java Class转换成actionScript
	 * 
	 * @param javaClass
	 */
	public void generateAsFile(Class javaClass) {
		if (generated.get(javaClass.getName()) != null)
			return;

		String packageName = javaClass.getPackage() == null ? "" : javaClass
				.getPackage().getName();
		packageName = packageName.replace(".", "/");

		// 输出路径
		File path = new File(outPath + packageName);

		// 输出文件
		File f = new File(path, javaClass.getSimpleName() + ".as");

		if (!f.exists() || override) {
			generated.put(javaClass.getName(), f.getName());

			String sb = generateAsPackageBody(javaClass);
			if (!path.exists()) {
				path.mkdirs();
			}

			// 输出文件

			System.out.println("正在产生" + f.getAbsolutePath());
			try {
				FileOutputStream fous = new FileOutputStream(f);
				fous.write(sb.toString().getBytes());
				fous.flush();
				fous.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 产生Actionscript Package body
	 * 
	 * @param javaClass
	 * @return
	 */
	private String generateAsPackageBody(Class javaClass) {
		if (javaClass == null)
			return null;

		String packageName = javaClass.getPackage() == null ? "" : javaClass
				.getPackage().getName();
		StringBuffer sb = new StringBuffer("package " + packageName + "{\n");
		sb.append("#ClassBody\n");
		sb.append("}\n");
		int start = sb.indexOf("#ClassBody");
		sb.replace(start, start + "#ClassBody".length(), generateAsClassBody(
				javaClass).toString());
		return sb.toString();
	}

	/**
	 * 产生Actionscript Class body
	 * 
	 * @param javaClass
	 * @return
	 */
	private String generateAsClassBody(Class javaClass) {
		if (javaClass == null)
			return "";

		Class cls = javaClass.getSuperclass();
		if (cls == null)
			return "";

		String extendsStr = "";
		if (!cls.getSimpleName().equalsIgnoreCase("Object")
				&& generateAssociateClass) {
			extendsStr = " extends " + cls.getName();
			generateAsFile(cls);
		}

		StringBuffer sb = new StringBuffer(repeat(" ", 4) + "public class "
				+ javaClass.getSimpleName() + extendsStr + "{\n");
		sb.append("#ConstructorBody\n");
		sb.append("#ProperiesBody\n");
		sb.append("    }\n");

		int start = sb.indexOf("#ProperiesBody");
		sb.replace(start, start + "#ProperiesBody".length(),
				generateAsFiledBody(javaClass).toString());

		start = sb.indexOf("#ConstructorBody");
		sb.replace(start, start + "#ConstructorBody".length(),
				generateAsClassConstructor(javaClass));
		return sb.toString();
	}

	/**
	 * 产生Actionscript 构造方法
	 * 
	 * @param javaClass
	 * @return
	 */
	private String generateAsClassConstructor(Class javaClass) {
		StringBuffer sb = new StringBuffer(repeat(" ", 8) + "public "
				+ javaClass.getSimpleName() + "(){\n");
		sb.append(repeat(" ", 8) + "}\n");
		return sb.toString();
	}

	/**
	 * 产生Actionscript 属性
	 * 
	 * @param javaClass
	 * @return
	 */
	private StringBuffer generateAsFiledBody(Class javaClass) {
		Field[] fields = javaClass.getDeclaredFields();
		StringBuffer sb = new StringBuffer("");
		// 写属性
		for (int i = 0; i < fields.length; i++) {
			Class fieldType = fields[i].getType();

			String typeName = getAsType(fieldType);
			if (typeName.equalsIgnoreCase("Object") && generateAssociateClass) {
				typeName = fieldType.getName();
				generateAsFile(fieldType);
			}
			sb.append(repeat(" ", 8) + "public var " + fields[i].getName()
					+ ": " + typeName + ";\n");

		}
		return sb;
	}

	/**
	 * 重复c字符count次，用于格式化生成的as文件
	 * 
	 * @param c
	 * @param count
	 * @return
	 */
	private static String repeat(String c, int count) {
		String temp = "";
		for (int i = 0; i < count; i++) {
			temp += c;
		}

		return temp;
	}

	/**
	 * 要据java类，找到对应的数据类型
	 * 
	 * @param javaType
	 * @return
	 */
	private String getAsType(Class javaType) {
		Map<String, String> dataTypeMap = getDataTypeMap();
		String asType = dataTypeMap.get(javaType.getName());
		if (asType != null) {
			return asType;
		} else {
			return "Object";
		}
	}

	/**
	 * java数据类型和actionScript数据类型对应关系
	 * 
	 * @return
	 */
	private Map getDataTypeMap() {
		Map<String, String> dataTypeMap = new HashMap<String, String>();
		dataTypeMap.put("java.lang.String", "String");
		dataTypeMap.put("java.lang.Boolean, boolean", "Boolean");
		dataTypeMap.put("boolean", "Boolean");
		dataTypeMap.put("java.lang.Integer", "Number");
		dataTypeMap.put("java.lang.Short", "Number");
		dataTypeMap.put("java.lang.Byte", "Number");
		dataTypeMap.put("java.lang.Byte[]", "flash.utils.ByteArray");
		dataTypeMap.put("java.lang.Double", "Number");
		dataTypeMap.put("java.lang.Long", "Number");
		dataTypeMap.put("java.lang.Float", "Number");
		dataTypeMap.put("java.lang.Character", "String");
		dataTypeMap.put("java.lang.Character[]", "String");
		dataTypeMap.put("java.util.Calendar", "Date");
		dataTypeMap.put("java.util.Date", "Date");
		dataTypeMap.put("java.lang.Object", "Object");
		dataTypeMap
				.put("java.util.Collection", "mx.collection.ArrayCollection");
		dataTypeMap.put("java.lang.Object[]", "Array");
		dataTypeMap.put("java.util.Map", "Object");
		return dataTypeMap;
	}

	public String getOutPath() {
		return outPath;
	}

	public void setOutPath(String outPath) {
		this.outPath = outPath;
	}

	public boolean isOverride() {
		return override;
	}

	public void setOverride(boolean override) {
		this.override = override;
	}

	public boolean isGenerateAssociateClass() {
		return generateAssociateClass;
	}

	public void setGenerateAssociateClass(boolean generateAssociateClass) {
		this.generateAssociateClass = generateAssociateClass;
	}
}
