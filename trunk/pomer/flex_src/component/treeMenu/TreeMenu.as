package component.treeMenu
{
	import mx.collections.ICollectionView;
	import mx.containers.VBox;
	import mx.events.CollectionEvent;
	import mx.events.CollectionEventKind;
	
	public class TreeMenu extends VBox
	{
		public function TreeMenu()
		{
		}
		
		private var _dataProvider:ICollectionView;
		
		public function get dataProvider():Object{
			return _dataProvider;
		}
		
		public function set dataProvider(value:Object):void
	    {
//	        if (_dataProvider)
//	        {
//	            _dataProvider.removeEventListener(CollectionEvent.COLLECTION_CHANGE, dataProviderChangeHandler);
//	        }
//	
//	        if (value is Array)
//	        {
//	            _dataProvider = new Array_dataProvider(value as Array);
//	        }
//	        else if (value is I_dataProviderView)
//	        {
//	            _dataProvider = I_dataProviderView(value);
//	        }
//	        else if (value is IList)
//	        {
//	            _dataProvider = new List_dataProviderView(IList(value));
//	        }
//	        else if (value is XMLList)
//	        {
//	            _dataProvider = new XMLList_dataProvider(value as XMLList);
//	        }
//	        else if (value is XML)
//	        {
//	            var xl:XMLList = new XMLList();
//	            xl += value;
//	            _dataProvider = new XMLList_dataProvider(xl);
//	        }
//	        // get an iterator for the displaying rows.  The _dataProviderView's
//	        // main iterator is left unchanged so folks can use old DataSelector
//	        // methods if they want to
//	        iterator = _dataProvider.createCursor();
//	        _dataProviderIterator = _dataProvider.createCursor(); //IViewCursor(_dataProvider);
//	
//	        // trace("ListBase added change listener");
//	        _dataProvider.addEventListener(_dataProviderEvent._dataProvider_CHANGE, _dataProviderChangeHandler, false, 0, true);
//	
//	        var event:CollectionEvent = new CollectionEvent(CollectionEvent.COLLECTION_CHANGE);
//	        event.kind = CollectionEventKind.RESET;
//	        dataProviderChangeHandler(event);
//	        dispatchEvent(event);
	    }
	    
	    private function dataProviderChangeHandler(event:CollectionEvent):void{
	    	
	    }

	}
}