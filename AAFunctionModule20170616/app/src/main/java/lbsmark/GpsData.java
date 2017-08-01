package lbsmark;

import java.util.ArrayList;
import java.util.List;

public class GpsData implements Cloneable {
	/**
	 * 纬度
	 */
	public String Latitude;
	/**
	 * 经度
	 */
	public String Longitude;
	/**
	 * GPS时间
	 */
	public String GpsTime;

	/**
	 * 位置类型
	 */
	public String locType;
	/**
	 * 反地理编码
	 */
	public String Addr;
	/**
	 * 当前城市
	 */
	public String City;
	/**
	 * 当前区域
	 */
	public String Area;
	/**
	 * 周边位置
	 */
	public List<String> aroundAddrs = new ArrayList<String>();
	/**
	 * 用户名
	 */
	public String workNum;

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

}
