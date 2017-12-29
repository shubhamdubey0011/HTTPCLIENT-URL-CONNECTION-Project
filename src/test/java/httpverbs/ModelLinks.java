package httpverbs;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelLinks
{

	

	

	@SerializedName("logo-image")
	@Expose
	private String logoImage;
	@SerializedName("userVideoDetails")
	@Expose
	private String userVideoDetails;
	@SerializedName("template-image")
	@Expose
	private String templateImage;
	@SerializedName("sharelink")
	@Expose
	private String sharelink;
	@SerializedName("channel")
	@Expose
	private String channel;
	@SerializedName("self")
	@Expose
	private String self;
	@SerializedName("publisher")
	@Expose
	private String publisher;
	@SerializedName("default-image")
	@Expose
	private String defaultImage;
	@SerializedName("cell-image")
	@Expose
	private String cellImage;
	@SerializedName("channel-subscription-status")
	@Expose
	private String channelSubscriptionStatus;

	public String getLogoImage() {
	return logoImage;
	}

	public void setLogoImage(String logoImage) {
	this.logoImage = logoImage;
	}

	public String getUserVideoDetails() {
	return userVideoDetails;
	}

	public void setUserVideoDetails(String userVideoDetails) {
	this.userVideoDetails = userVideoDetails;
	}

	public String getTemplateImage() {
	return templateImage;
	}

	public void setTemplateImage(String templateImage) {
	this.templateImage = templateImage;
	}

	public String getSharelink() {
	return sharelink;
	}

	public void setSharelink(String sharelink) {
	this.sharelink = sharelink;
	}

	public String getChannel() {
	return channel;
	}

	public void setChannel(String channel) {
	this.channel = channel;
	}

	public String getSelf() {
	return self;
	}

	public void setSelf(String self) {
	this.self = self;
	}

	public String getPublisher() {
	return publisher;
	}

	public void setPublisher(String publisher) {
	this.publisher = publisher;
	}

	public String getDefaultImage() {
	return defaultImage;
	}

	public void setDefaultImage(String defaultImage) {
	this.defaultImage = defaultImage;
	}

	public String getCellImage() {
	return cellImage;
	}

	public void setCellImage(String cellImage) {
	this.cellImage = cellImage;
	}

	public String getChannelSubscriptionStatus() {
	return channelSubscriptionStatus;
	}

	public void setChannelSubscriptionStatus(String channelSubscriptionStatus) 
	{
	this.channelSubscriptionStatus = channelSubscriptionStatus;
	}

	}


	
	

