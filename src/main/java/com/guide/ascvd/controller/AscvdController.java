package com.guide.ascvd.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guide.ascvd.pojo.ASCVD;
import com.guide.ascvd.pojo.DoctorDetail;
import com.guide.ascvd.service.AscvdService;
import com.guide.utils.JsonUtil;

@Controller
@RequestMapping("/ascvd")
public class AscvdController {

	@Resource(name = "AscvdService")
	private AscvdService ascvdService;
	private Logger logger;

	public AscvdController() {
		this.logger = Logger.getLogger(AscvdController.class);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "hospital", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String Validate(HttpServletRequest request) {
		List<ASCVD> doc_prov = ascvdService.queryDoctorProv();
		List<ASCVD> doc_city = ascvdService.queryDoctorCity();
		List<ASCVD> hos_prov = ascvdService.queryHospitalProv();
		List<ASCVD> hos_city = ascvdService.queryHospitalCity();
		List<ASCVD> keshi_list = ascvdService.queryKeShi();
		JSONArray Doc_arr_prov = new JSONArray();
		for (ASCVD doc : doc_prov) {
			JSONObject Doc_obj = new JSONObject();
			Doc_obj.put("name", doc.getSerialName());
			Doc_obj.put("value", doc.getSerialCount1());
			Doc_arr_prov.add(Doc_obj);
		}
		JSONArray Doc_arr_city = new JSONArray();
		for (ASCVD doc : doc_city) {
			JSONObject Doc_obj = new JSONObject();
			Doc_obj.put("name", doc.getSerialName());
			Doc_obj.put("value", doc.getSerialCount1());
			Doc_arr_city.add(Doc_obj);
		}
		JSONArray Hos_arr_prov = new JSONArray();
		for (ASCVD hos : hos_prov) {
			JSONObject Hos_obj = new JSONObject();
			Hos_obj.put("name", hos.getSerialName());
			Hos_obj.put("value", hos.getSerialCount1());
			Hos_arr_prov.add(Hos_obj);
		}
		JSONArray Hos_arr_city = new JSONArray();
		for (ASCVD hos : hos_city) {
			JSONObject Hos_obj = new JSONObject();
			Hos_obj.put("name", hos.getSerialName());
			Hos_obj.put("value", hos.getSerialCount1());
			Hos_arr_city.add(Hos_obj);
		}
		request.setAttribute("Doc_prov", Doc_arr_prov);
		request.setAttribute("Doc_city", Doc_arr_city);
		request.setAttribute("Hos_prov", Hos_arr_prov);
		request.setAttribute("Hos_city", Hos_arr_city);
		request.setAttribute("Pie_keshi", keshi_list);
		return "ascvd/hospital";
	}

	@RequestMapping(value = "course", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String course(HttpServletRequest request) {
		List<ASCVD> course_list = ascvdService.queryCourse();
		request.setAttribute("Pie_course", course_list);
		return "ascvd/course";
	}

	@RequestMapping(value = "date", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String date(HttpServletRequest request) {
		List<ASCVD> datecoursereg_list = ascvdService.queryDateCourseReg();
		request.setAttribute("Line_date", datecoursereg_list);
		return "ascvd/date";
	}

	@RequestMapping(value = "query_detailinfo", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String query_detailinfo(HttpServletRequest request) {
		return "ascvd/query_detailinfo";
	}

	@RequestMapping(value = "patient", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	public String patient(HttpServletRequest request) {
		List<ASCVD> CourseDoctorPatient_list = ascvdService.queryCourseDoctorPatient();
		List<ASCVD> CoursePatientViewer_list = ascvdService.queryCoursePatientViewer();
		request.setAttribute("Bar_doctor", CourseDoctorPatient_list);
		request.setAttribute("Bar_viewer", CoursePatientViewer_list);
		return "ascvd/patient";
	}

	@RequestMapping(value = "ajaxcity_data", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String hypt(HttpServletRequest request, @RequestParam("selectedProvince") String selectedProvince)
			throws Exception {
		List<ASCVD> list = ascvdService.getDoctorByCity(selectedProvince);
		return JsonUtil.object2json(list);
	}

	@RequestMapping(value = "ajaxhoscity_data", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String gethoscity_data(HttpServletRequest request, @RequestParam("selectedProvince") String selectedProvince)
			throws Exception {
		List<ASCVD> list = ascvdService.getHospitalByCity(selectedProvince);
		return JsonUtil.object2json(list);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "datatable_query", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String datatable_query(HttpServletRequest request, @RequestParam("search[value]") String search,
			@RequestParam("draw") int draw, @RequestParam("start") int start) throws Exception {
		String str = request.getParameter("search[value]");
		logger.info("查询：【"+str+"】");
		if (str.contains("\"")) {
			str = str.replace(str.substring(str.indexOf("\""), str.length()), "");
		}
		int len = ascvdService.dataTableDoctorDetailCount(str);
		List<DoctorDetail> list = ascvdService.dataTableDoctorDetail(start, str);
		JSONObject json = new JSONObject();
		List<List<String>> list1 = new ArrayList<List<String>>();
		List<String> list2 = new ArrayList<String>();

		for (DoctorDetail i : list) {
			list2.add(i.getCityName());
			list2.add(i.getDoctorName());
			list2.add(i.getHospitalName());
			list2.add(i.getKeShiName());
			list1.add(list2);
			list2 = new ArrayList<String>();
		}
		json.put("data", list1);
		json.put("recordsTotal", len);
		json.put("recordsFiltered", len);
		json.put("draw", draw);
		return json.toJSONString();
	}

}
