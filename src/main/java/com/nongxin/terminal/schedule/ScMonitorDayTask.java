package com.nongxin.terminal.schedule;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nongxin.terminal.dao.envmonitor.EnvMonitorScMapper;
import com.nongxin.terminal.dao.envmonitor.EquipmentMapper;
import com.nongxin.terminal.entity.envmonitor.EnvMonitorSc;
import com.nongxin.terminal.entity.envmonitor.Equipment;
import com.nongxin.terminal.mqtt.FactoryEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 抓取三川采集设备数据
 */
//@Component
//@Configuration
//@EnableScheduling
public class ScMonitorDayTask {

    @Autowired
    private EnvMonitorScMapper envMonitorScdao;

    @Autowired
    private EquipmentMapper equipmentDao;

    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(fixedRate=14*60*1000)
    private void configureTasks() {
        String json = null;
        try {
            json = this.getJson();
            JSONObject jsonObject = JSONObject.parseObject(json);
            String code = jsonObject.getString("code");
            //System.out.println("code:"+code);
            JSONArray data =  jsonObject.getJSONArray("data");
            for(int i=0;i<data.size();i++){

                JSONObject current = data.getJSONObject(i);
                JSONObject item = current.getJSONObject("current");
                String dev_id = item.getString("dev_id");
                int devId = this.getEquMentId(dev_id);
                Timestamp updated_at = item.getTimestamp("updated_at");
                //System.out.println("updated_at:"+updated_at);
                if(!this.exist(devId,updated_at)){
                    EnvMonitorSc envMonitor = new EnvMonitorSc();
                    envMonitor.setEquipmentId(devId);
                    envMonitor.setAirTemperature(getBigDecimalData(item,"ap_temp"));
                    envMonitor.setAirHumidity(getBigDecimalData(item,"ap_humi"));
                    envMonitor.setAirPressure(getBigDecimalData(item,"ap_pre"));
                    envMonitor.setWindSpeed(getBigDecimalData(item,"ap_wsp"));
                    envMonitor.setWindDirection(getBigDecimalData(item,"ap_wdd"));
                    envMonitor.setRainfall(getBigDecimalData(item,"ap_rain"));
                    envMonitor.setSoilTemperature(getBigDecimalData(item,"soil_temp"));
                    envMonitor.setSoilHumidity(getBigDecimalData(item,"soil_humi"));
                    envMonitor.setSoilPh(getBigDecimalData(item,"soil_ph"));
                    envMonitor.setMonitorTime((Date)updated_at);
                    envMonitor.setFactoryId(FactoryEnum.SANCHUAN.getFactoryId());
                    envMonitorScdao.insertSelective(envMonitor);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public boolean exist(int devId,Timestamp updatedAt){
        EnvMonitorSc e = new EnvMonitorSc();
        e.setMonitorTime((Date) updatedAt);
        e.setEquipmentId(devId);
        //判断是否存在
        List<EnvMonitorSc> envMonitors = envMonitorScdao.selectByEquipIdAndMeasureTime(e);
        if(envMonitors.size()>0){
            return true;
        }
        return false;
    }

    public BigDecimal getBigDecimalData(JSONObject item, String key){
        BigDecimal data = null;
        try {
            data = item.getBigDecimal(key);
        } catch (Exception e) {
        }
        return data;
    }

    public int getEquMentId(String devId){
        Equipment equipment = equipmentDao.selectByEquipmentId(devId);
        if(equipment!=null){
            return equipment.getId();
        }else{
            return 0;
        }
    }

    public String getJson(){
        String url="http://mziot.suntrans-cloud.com/getData";
        //String json =restTemplate.getForObject(url,Object.class);
        ResponseEntity<String> results = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        String json = results.getBody();
        return json;
    }
}
