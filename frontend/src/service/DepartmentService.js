import axios from "axios";

const DEPARTMENTS_API_URL = "http://localhost:8080/department";
axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

class DepartmentService {
  getAllDepartments() {
    return axios.get(`${DEPARTMENTS_API_URL}/departments`);
  };


}

export default new DepartmentService();