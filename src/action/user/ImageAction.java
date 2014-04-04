package action.user;


import java.awt.image.BufferedImage;

import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;

import util.ImageUtil;

import action.BaseAction;






public class ImageAction extends BaseAction{
  private InputStream imageStream;
  private String key;

  public String execute(){
 
    Map<String,BufferedImage> map = ImageUtil.createImage();
    for (Iterator i=map.keySet().iterator();i.hasNext();){
    	System.out.println("map<String,BufferedImage>:"+i.next());
    }
    key = map.keySet().iterator().next();

    
    System.out.println("code:"+key);
    BufferedImage image = map.get(key);
  
    try {
  
     imageStream = ImageUtil.change(image);
     session.put("code", key);

      return "success";

    } catch (Exception e) {
      e.printStackTrace();
      return "error";
    }
    
  }
  
  //get put method: ImageStream

public InputStream getImageStream() {
	return imageStream;
}


public void setImageStream(InputStream imageStream) {
	this.imageStream = imageStream;
}


public String getKey() {
	return key;
}


public void setKey(String key) {
	this.key = key;
}


  
  
 

  
}
