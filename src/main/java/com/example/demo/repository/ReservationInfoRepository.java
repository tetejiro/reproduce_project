package com.example.demo.repository;

import com.example.demo.logic.entity.AllReservationInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Mapper
public interface ReservationInfoRepository {

    @Select("select name from hospitals where id = #{id}")
    String getHospitalName(@Param("id") int id);

    @Select("select distinct target_time from AllReservationInfoView where target_date = #{date} order by target_time")
    List<LocalTime> getSortedDistinctTargetTime(@Param("date") LocalDate date);

    @Select("select * from AllReservationInfoView where target_time = #{frameTime}")
    List<AllReservationInfoEntity> getReserveInfo(@Param("frameTime") LocalTime frameTime);
}
