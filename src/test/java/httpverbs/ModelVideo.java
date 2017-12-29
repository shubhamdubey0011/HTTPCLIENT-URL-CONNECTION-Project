package httpverbs;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelVideo 
{


@SerializedName("type")
@Expose
private String type;
@SerializedName("id")
@Expose
private String id;
@SerializedName("title")
@Expose
private String title;
@SerializedName("shortDescription")
@Expose
private String shortDescription;
@SerializedName("longDescription")
@Expose
private String longDescription;
@SerializedName("liveBroadcastTime")
@Expose
private String liveBroadcastTime;
@SerializedName("createTime")
@Expose
private String createTime;
@SerializedName("channelTitle")
@Expose
private String channelTitle;
@SerializedName("episode")
@Expose
private String episode;
@SerializedName("duration")
@Expose
private String duration;
@SerializedName("parentalGuidance")
@Expose
private String parentalGuidance;
@SerializedName("channelId")
@Expose
private String channelId;
@SerializedName("externalId")
@Expose
private String externalId;
@SerializedName("publishTime")
@Expose
private String publishTime;
@SerializedName("onDemandTimeBegin")
@Expose
private String onDemandTimeBegin;
@SerializedName("onDemandTimeEnd")
@Expose
private String onDemandTimeEnd;
@SerializedName("expireDate")
@Expose
private String expireDate;
@SerializedName("badge")
@Expose
private String badge;
@SerializedName("links")
@Expose
private ModelLinks links;
@SerializedName("playbackItems")
@Expose
private List<Object> playbackItems = null;

public String getType() {
return type;
}

public void setType(String type) {
this.type = type;
}

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public String getShortDescription() {
return shortDescription;
}

public void setShortDescription(String shortDescription) {
this.shortDescription = shortDescription;
}

public String getLongDescription() {
return longDescription;
}

public void setLongDescription(String longDescription) {
this.longDescription = longDescription;
}

public String getLiveBroadcastTime() {
return liveBroadcastTime;
}

public void setLiveBroadcastTime(String liveBroadcastTime) {
this.liveBroadcastTime = liveBroadcastTime;
}

public String getCreateTime() {
return createTime;
}

public void setCreateTime(String createTime) {
this.createTime = createTime;
}

public String getChannelTitle() {
return channelTitle;
}

public void setChannelTitle(String channelTitle) {
this.channelTitle = channelTitle;
}

public String getEpisode() {
return episode;
}

public void setEpisode(String episode) {
this.episode = episode;
}

public String getDuration() {
return duration;
}

public void setDuration(String duration) {
this.duration = duration;
}

public String getParentalGuidance() {
return parentalGuidance;
}

public void setParentalGuidance(String parentalGuidance) {
this.parentalGuidance = parentalGuidance;
}

public String getChannelId() {
return channelId;
}

public void setChannelId(String channelId) {
this.channelId = channelId;
}

public String getExternalId() {
return externalId;
}

public void setExternalId(String externalId) {
this.externalId = externalId;
}

public String getPublishTime() {
return publishTime;
}

public void setPublishTime(String publishTime) {
this.publishTime = publishTime;
}

public String getOnDemandTimeBegin() {
return onDemandTimeBegin;
}

public void setOnDemandTimeBegin(String onDemandTimeBegin) {
this.onDemandTimeBegin = onDemandTimeBegin;
}

public String getOnDemandTimeEnd() {
return onDemandTimeEnd;
}

public void setOnDemandTimeEnd(String onDemandTimeEnd) {
this.onDemandTimeEnd = onDemandTimeEnd;
}

public String getExpireDate() {
return expireDate;
}

public void setExpireDate(String expireDate) {
this.expireDate = expireDate;
}

public String getBadge() {
return badge;
}

public void setBadge(String badge) {
this.badge = badge;
}

public ModelLinks getLinks() {
return links;
}

public void setLinks(ModelLinks links) {
this.links = links;
}

public List<Object> getPlaybackItems() {
return playbackItems;
}

public void setPlaybackItems(List<Object> playbackItems) {
this.playbackItems = playbackItems;
}
	
	
}
