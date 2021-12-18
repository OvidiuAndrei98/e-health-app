import axios from "axios";

const ROOM_API_URL = "http://localhost:8080/room";
axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

class RoomService {
  getAllRoomsForDepartment(departmentId) {
    return axios.get(`${ROOM_API_URL}/rooms/${departmentId}`);
  };


}

export default new RoomService();