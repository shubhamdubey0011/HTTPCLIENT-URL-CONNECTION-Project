package httpverbs;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelMerlin {
	
	@SerializedName("uuid")
	@Expose
	private String uuid;
	@SerializedName("fensEvent")
	@Expose
	private ModelFensEvent fensEvent;
	@SerializedName("rss")
	@Expose
	private Object rss;
	@SerializedName("rssXml")
	@Expose
	private Object rssXml;
	@SerializedName("ffwesXml")
	@Expose
	private Object ffwesXml;

	public String getUuid() {
	return uuid;
	}

	public void setUuid(String uuid) {
	this.uuid = uuid;
	}

	public ModelFensEvent getFensEvent() {
	return fensEvent;
	}

	public void setFensEvent(ModelFensEvent fensEvent) {
	this.fensEvent = fensEvent;
	}

	public Object getRss() {
	return rss;
	}

	public void setRss(Object rss) {
	this.rss = rss;
	}

	public Object getRssXml() {
	return rssXml;
	}

	public void setRssXml(Object rssXml) {
	this.rssXml = rssXml;
	}

	public Object getFfwesXml() {
	return ffwesXml;
	}

	public void setFfwesXml(Object ffwesXml) {
	this.ffwesXml = ffwesXml;
	}

}
