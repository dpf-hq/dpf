//		//
//		//Add missing Ids: (while keeping comments)
//		//
//		final ICompositeNode c = NodeModelUtils.findActualNodeFor(model);
//		final StringBuffer buffer = new StringBuffer();
//		BidiTreeIterator<INode> ti = c.getAsTreeIterable().iterator();
//		StringBuffer cache = new StringBuffer();
//		boolean incompleteDpfId=false;
//		DpfId id = null;
//		while(ti.hasNext()){
//			final INode n = ti.next();
//			if(n instanceof LeafNode){		
//				if(n.getSemanticElement() instanceof DpfId){
//					id = (DpfId)n.getSemanticElement(); 
//					if(id.getId() < 1){
//						incompleteDpfId=true;
//						cache.append(n.getText());
//					}else{
//						buffer.append(n.getText());
//					}
//				}else{
//					if(incompleteDpfId){
//						buffer.append(cache.toString().replaceFirst(id.getName(),id.getName() + "@100"));
//						cache = new StringBuffer();
//					    incompleteDpfId=false;
//					}
//					buffer.append(n.getText());
//				}
//			}
//		}
