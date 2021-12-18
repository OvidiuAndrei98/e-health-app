import axios from "axios";

const NURSE_API_URL = "http://localhost:8080/nurse";
axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

class NurseService {
  searchNursesForDept(id,search) {
    return axios.get(`${NURSE_API_URL}/search-nurses/${id}/${search}`);
  };

  getAllNurses() {
    return axios.get(`${NURSE_API_URL}/nurses`);
  };

  getNurseForPatient(patient){
    return axios.post(`${NURSE_API_URL}/nurse-for-patient`, patient);
}

}

export default new NurseService();