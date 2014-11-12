object Test {

 	def main(args: Array[String]) = {
 	 val start = System.currentTimeMillis() 
 	 for(i<-1 to 10000){
 	   no.hib.dpf.text.graph.TestCases.main(null)
 	 } 
 	 println("Needed for 10000 executions:" + (System.currentTimeMillis() - start))
 	}
	
}