package httpverbs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelAttributes
{

	@SerializedName("tenant")
	@Expose
	private String tenant;
	@SerializedName("platforms")
	@Expose
	private String platforms;
	@SerializedName("uuid")
	@Expose
	private String uuid;

	public String getTenant() {
	return tenant;
	}

	public void setTenant(String tenant) {
	this.tenant = tenant;
	}

	public String getPlatforms() {
	return platforms;
	}

	public void setPlatforms(String platforms) {
	this.platforms = platforms;
	}

	public String getUuid() {
	return uuid;
	}

	public void setUuid(String uuid) {
	this.uuid = uuid;
	}

	
}
