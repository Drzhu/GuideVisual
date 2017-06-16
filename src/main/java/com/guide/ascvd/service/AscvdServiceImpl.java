package com.guide.ascvd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guide.ascvd.mapper.AscvdMapper;
import com.guide.ascvd.pojo.ASCVD;
import com.guide.ascvd.pojo.DoctorDetail;

@Service(value="AscvdService")
public class AscvdServiceImpl implements AscvdService{

	@Autowired
	private AscvdMapper ascvdMapper;

	public List<ASCVD> queryKeShi() {
		// TODO Auto-generated method stub
		return ascvdMapper.queryKeShi();
	}

	public List<ASCVD> queryCourseDoctorPatient() {
		// TODO Auto-generated method stub
		return ascvdMapper.queryCourseDoctorPatient();
	}

	public List<ASCVD> queryCourse() {
		// TODO Auto-generated method stub
		return ascvdMapper.queryCourse();
	}

	public List<ASCVD> queryCoursePatientViewer() {
		// TODO Auto-generated method stub
		return ascvdMapper.queryCoursePatientViewer();
	}

	public List<ASCVD> queryDateCourseReg() {
		// TODO Auto-generated method stub
		return ascvdMapper.queryDateCourseReg();
	}

	public List<ASCVD> queryDoctorProv() {
		// TODO Auto-generated method stub
		return ascvdMapper.queryDoctorProv();
	}

	public List<ASCVD> queryDoctorCity() {
		// TODO Auto-generated method stub
		return ascvdMapper.queryDoctorCity();
	}

	public List<ASCVD> getDoctorByCity(String selectedProvince) {
		// TODO Auto-generated method stub
		return ascvdMapper.getDoctorByCity(selectedProvince);
	}

	public List<DoctorDetail> dataTableDoctorDetail(int start,String keshi_name) {
		// TODO Auto-generated method stub
		return ascvdMapper.dataTableDoctorDetail(start,keshi_name);
	}

	public int dataTableDoctorDetailCount(String str) {
		// TODO Auto-generated method stub
		return ascvdMapper.dataTableDoctorDetailCount(str);
	}

	public List<ASCVD> queryHospitalProv() {
		// TODO Auto-generated method stub
		return ascvdMapper.queryHospitalProv();
	}

	public List<ASCVD> queryHospitalCity() {
		// TODO Auto-generated method stub
		return ascvdMapper.queryHospitalCity();
	}

	public List<ASCVD> getHospitalByCity(String selectedProvince) {
		// TODO Auto-generated method stub
		return ascvdMapper.getHospitalByCity(selectedProvince);
	}
	
}
