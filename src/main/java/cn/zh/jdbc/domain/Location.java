package cn.zh.jdbc.domain;

public class Location {
	 	private long id;
	    private String latitude;
	    private String longitude;

	    public long getId() {
	        return id;
	    }

	    public void setId(long id) {
	        this.id = id;
	    }

	    public String getLatitude() {
			return latitude;
		}

		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}

		public String getLongitude() {
			return longitude;
		}

		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}

		@Override
		public String toString() {
			return "Location [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + "]";
		}

		
}
