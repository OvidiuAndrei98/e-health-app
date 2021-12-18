import axios from "axios";
import AuthHeader from "./AuthHeader";

const PATIENT_API_URL = "http://localhost:8080/patients";
axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

class PatientService {
  savePatient(patient,id, patientDoctor, patientNurse) {
    patient.id = id;
    patient.doctorId = patientDoctor.id;
    return axios.put(`${PATIENT_API_URL}/save-patient`, patient , {headers: AuthHeader()});
  };

  getAllForDept(id) {
      console.log(id);
    return axios.get(`${PATIENT_API_URL}/patients/${id}`, {headers: AuthHeader()});
  }

 

}

export default new PatientService();