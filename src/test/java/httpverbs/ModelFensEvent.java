package httpverbs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelFensEvent 
{

	@SerializedName("resourceType")
	@Expose
	private String resourceType;
	@SerializedName("resourceId")
	@Expose
	private String resourceId;
	@SerializedName("eventType")
	@Expose
	private String eventType;
	@SerializedName("attributes")
	@Expose
	private ModelAttributes attributes;

	public String getResourceType() {
	return resourceType;
	}

	public void setResourceType(String resourceType) {
	this.resourceType = resourceType;
	}

	public String getResourceId() {
	return resourceId;
	}

	public void setResourceId(String resourceId) {
	this.resourceId = resourceId;
	}

	public String getEventType() {
	return eventType;
	}

	public void setEventType(String eventType) {
	this.eventType = eventType;
	}

	public ModelAttributes getAttributes() {
	return attributes;
	}

	public void setAttributes(ModelAttributes attributes) {
	this.attributes = attributes;
	}
	
}
