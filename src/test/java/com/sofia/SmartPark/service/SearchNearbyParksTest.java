/*

package com.sofia.SmartPark.service;

        import com.alibaba.fastjson.JSONObject;
        import com.sofia.SmartPark.mapper.AllParksMapper;
        import com.sofia.SmartPark.model.TbAllParks;
        import com.sofia.SmartPark.param.SearchNearbyParksParam;
        import com.sofia.SmartPark.vo.SearchNearbyParksVo;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.test.context.ContextConfiguration;
        import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

        import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext-*.xml")
public class SearchNearbyParksTest {

    @Autowired
    AllParksMapper allParksMapper;

    @Autowired
    SearchNearbyParksService searchNearbyParksService;

    @Test
    public void searchNearbyParkTest(){

        List<TbAllParks> tbAllParks;
        List<SearchNearbyParksVo> searchNearbyParksVos;
        SearchNearbyParksParam searchNearbyParksParam = new SearchNearbyParksParam();
        searchNearbyParksParam.setLatitude(343.234);
        searchNearbyParksParam.setLongitude(234.545);


        tbAllParks =   allParksMapper.getAllparks();
  searchNearbyParksVos = searchNearbyParksService.searchNearbyParks(343.234,234.545);
  System.out.println(JSONObject.toJSONString(searchNearbyParksVos));

    }
}
*/

