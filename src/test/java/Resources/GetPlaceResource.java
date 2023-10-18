package Resources;

public enum GetPlaceResource {

	
	getPlaceAPI("/maps/api/place/get/json"),
	addPlaceAPI("/maps/api/place/add/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	
			
	private String resources;
	
GetPlaceResource(String resources){
	
	this.resources=resources;
	
}

public  String getResources() {
	
	
	return resources;
	
}
}