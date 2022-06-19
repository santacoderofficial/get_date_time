# get_date_time
Get Date and Time From Internet android github

Step 1. Add the JitPack repository to your build file

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.santacoderofficial:get_date_time:Tag'
	}
  
  Step 3. Get Date and Time From Internet
  
          GetDateTime getDateTime = new GetDateTime(MainActivity.this);
        getDateTime.onGetDateTime(new GetDateTime.DateTimeInterface() {
            @Override
            public void onGetDateTime(String day, String month, String year, String hour, String minute, String second) {
                txt.setText(day+"-"+month+"-"+year+" || "+ hour+":"+minute+":"+second);
            }
        });
