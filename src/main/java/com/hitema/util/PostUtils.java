package com.hitema.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public final class PostUtils {

	public static ClientResponse appelPost(String url, Object object){		
		ClientResponse response = null;
		try {
			Client client = Client.create();
			WebResource webResource = client
					.resource(url);
			String json = convertionObjetEnJson(object);
			response = webResource.type("application/json")
					.post(ClientResponse.class, json);
			System.out.println(response.getEntity(String.class));
			if (response.getStatus() != 201) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return response;
	}
	
	private static  String convertionObjetEnJson(Object object){
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		return gson.toJson(object);
	}

}

