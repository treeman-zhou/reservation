package cn.edu.nefu.library.service.impl;

import cn.edu.nefu.library.common.LibException;
import cn.edu.nefu.library.core.mapper.ConfigMapper;
import cn.edu.nefu.library.core.model.Config;
import cn.edu.nefu.library.service.ReservationAreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : pc
 * @date : 2018/10/30
 * @since : Java 8
 */
@Service
public class ReservationAreaServiceImpl implements ReservationAreaService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ConfigMapper configMapper;

    @Autowired
    public ReservationAreaServiceImpl(ConfigMapper configMapper) {
        this.configMapper = configMapper;
    }

    @Override
    public List<Integer> getReservationArea() throws LibException {

        List<Config> configs = configMapper.selectOpenAera();
        if (null == configs) {
            throw new LibException("预约区域为空");
        } else {

            List<Integer> rtv = new ArrayList<>(4);
            for (Config config : configs ) {
                if( "area_two_n".equals(config.getConfigKey()) && "1".equals(config.getConfigValue())){
                    rtv.add(1);
                }
                if( "area_two_s".equals(config.getConfigKey()) && "1".equals(config.getConfigValue())){
                    rtv.add(2);
                }
                if( "area_three_n".equals(config.getConfigKey()) && "1".equals(config.getConfigValue())){
                    rtv.add(3);
                }
                if( "area_three_s".equals(config.getConfigKey()) && "1".equals(config.getConfigValue())){
                    rtv.add(4);
                }
            }

            return rtv;
        }
    }
}