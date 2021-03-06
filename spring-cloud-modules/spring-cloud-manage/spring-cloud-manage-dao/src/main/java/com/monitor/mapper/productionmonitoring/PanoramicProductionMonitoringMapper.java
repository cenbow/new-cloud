package com.monitor.mapper.productionmonitoring;

import com.cloud.core.IMapper;
import com.monitor.dto.productionmonitoring.Productionmonitoringinfo;
import com.monitor.model.productionmonitoring.PanoramicProductionMonitoring;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author summer
 */
@Repository("productionMonitoringMapper")
public interface PanoramicProductionMonitoringMapper extends IMapper<PanoramicProductionMonitoring> {
	
    /**
     * 指定时间获取生产监控内容
     * @param
     * @param date
     * @return
     */
    @Select("SELECT\n" + 
    		"	round(\n" + 
    		"		calcium_phosphate_ore_consumption ,\n" + 
    		"		2\n" + 
    		"	) AS cpoc ,\n" + 
    		"	round(\n" + 
    		"		calcium_phosphate_acid_consumption ,\n" + 
    		"		2\n" + 
    		"	) AS cpac ,\n" + 
    		"	round(coal_calcium_phosphate , 2) AS ccp ,\n" + 
    		"	round(calcium_power_consumption , 2) AS cpc,\n" +
    		"	round(power_consumption_of_calcium_phosphate , 2) AS pcc\n" +
    		"FROM\n" + 
    		"	panoramic_production_monitoring\n" + 
    		"WHERE\n" + 
    		"	DATE_FORMAT(ctime,\"%Y-%m-%d\") = #{date}\n" +
    		"   delete_flag = 1" +
    		"")
    Productionmonitoringinfo findByDate(@Param("date") String date);
}
