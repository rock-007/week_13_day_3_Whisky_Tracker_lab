package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

    @Autowired
    WhiskyRepository whiskyRepository;
    @Autowired
    DistilleryRepository distilleryRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void getAllWhiskies() {
        List<Whisky> allWhisky = whiskyRepository.findWhiskyByYear(2018);
        System.out.println(allWhisky);
        assertEquals(6, allWhisky.size());
    }

    @Test
    public void getAllDistilleriesForParticularRegion() {
        List<Distillery> distilleries = distilleryRepository.findDistilleryByRegion("Highland");
        assertEquals(3, distilleries.size());
    }

    @Test
    public void getAllWhiskyFromSpecificDistilleryAndAge() {
        Distillery distillery = distilleryRepository.getOne(8L);
        List<Whisky> whiskies = whiskyRepository.findWhiskyByDistilleryAndAgeGreaterThan(distillery, 11);
        assertEquals(2, whiskies.size());
    }

    @Test
    public void getAllWhiskyFromARegion() {
        List<Whisky> whiskies = whiskyRepository.findWhiskyByDistilleryRegion("Highland");


        assertEquals(7, whiskies.size());

    }

    @Test
    public void getDistilleriesOver12yearsOld() {
        List<Distillery> distilleries = distilleryRepository.findDistilleryByWhiskiesAgeGreaterThan(12);

        assertEquals(10, distilleries.size());

    }

}
