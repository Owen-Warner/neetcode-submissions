class TimeMap {
        boolean inz = false;
        HashMap<Integer, HashMap<String, String>> kV;

        public TimeMap() {
            inz = true;
            kV = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if(inz){
                if(kV.containsKey(timestamp)){
                    HashMap<String, String> temp = kV.get(timestamp);
                    temp.put(key, value);
                    kV.replace(timestamp, temp);
                }
                else{
                    HashMap<String, String> temp = new HashMap<>();
                    temp.put(key, value);
                    kV.put(timestamp, temp);
                }
            }
        }

        public String get(String key, int timestamp) {
            for(int i = timestamp; i >= 0; i--){
                if(kV.containsKey(i)){
                    HashMap<String, String> temp = kV.get(i);
                    if(temp.containsKey(key)){
                        return temp.get(key);
                    }
                }
            }
            return "";
        }
    }