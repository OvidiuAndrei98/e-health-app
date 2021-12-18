import axios from "axios";

const DOCTOR_API_URL = "http://localhost:8080/doctor";
axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

class DoctorService {
  getAllDoctors() {
    return axios.get(`${DOCTOR_API_URL}/doctors`);
  };

  searchDoctor(search) {
    return axios.get(`${DOCTOR_API_URL}/search/${search}`);
  };

  getDoctorForPatient(patient){
      return axios.post(`${DOCTOR_API_URL}/doctor-for-patient`, patient);
  }


}

export default new DoctorService();