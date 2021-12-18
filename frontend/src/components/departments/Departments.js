import React, {useState, useEffect} from 'react';
import Navbar from '../navigation/Navbar';
import TextField from '@mui/material/TextField';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import { makeStyles } from '@mui/styles';
import RoomCard from './RoomCard';
import Bed from "./Bed";
import DepartmentService from '../../service/DepartmentService';
import RoomService from '../../service/RoomService';
import BedService from '../../service/BedService';
import DoctorService from '../../service/DoctorService';
import NurseService from '../../service/NurseService';

const Departments = () => {
    const [departments, setDepartments] = useState([]);
    const [rooms, setRooms] = useState([]);
    const [beds, setBeds] = useState([]);
    const [roomId, setRoomId] = useState(null);
    const [departmentId, setDepartmentId] = useState(null);
    const [searchDoctor, setSearchDoctor] = useState([]);
    const [searchNurse, setSearchNurse] = useState([]);

useEffect(() => {
    DepartmentService.getAllDepartments().then(res => {
        setDepartments(res.data);
    });
} , []);

useEffect(() => {
    BedService.getAllBedsForRoom(roomId).then(res => {
        setBeds(res.data);
    });
} , [roomId]);

console.log(departments);

const handleDepartments = (event) => {
    if(event.target.value != "undefined") {
        RoomService.getAllRoomsForDepartment(event.target.value).then(res => {
            setRooms(res.data);
            setDepartmentId(event.target.value);
        });
    }
    setRooms([]);
    }


const useStyles = makeStyles((theme) => ({
    root: {
        height: 50,
          "& .MuiInputLabel-root.Mui-focused": {
            color: "#798BF2"
          },
          "& .MuiOutlinedInput-root.Mui-focused .MuiOutlinedInput-notchedOutline": {
            borderColor: "#798BF2"
          }
      },
  }));

  const classes = useStyles();

  const searchDoctors= (event) => {
      DoctorService.searchDoctor(event.target.value).then(res => {
            setSearchDoctor(res.data);
            console.log(searchDoctor);
        });
    }

      const searchNurses= (event) => {
          if(event.target.value != null) {
      NurseService.searchNursesForDept(departmentId,event.target.value).then(res => {
            setSearchNurse(res.data);
        });
    }
    }

    return (
        <>
            <Navbar />
            <div className="container d-flex row">
                <div className="section-container b-right f-1">
                    <div className="filter-container">
                        <FormControl variant="outlined" sx={{ minWidth: "100%" }}>
                            <TextField
                                className={classes.root}
                                size="small"
                                variant="outlined"
                                labelId="departments"
                                id="departments"
                                onChange={handleDepartments}
                                label="Departments"
                                select
                            >
                                <MenuItem value="undefined">
                                <em>None</em>
                                </MenuItem>
                                {departments.map(department => (
                                    <MenuItem key={department.id} value={department.id}>{department.name}</MenuItem>
                                ))}
                            </TextField>
                        </FormControl>
                    </div>
                    <div className="rooms-container">
                        {rooms.map(room => (
                            <RoomCard key={room.id} room={room} getRoomId = {roomId => setRoomId(roomId)} />
                        ))}
                    </div>
                </div>
                <div className="section-container f-3">
                    <div className="beds-container">
                        {beds.map(bed => (
                            <Bed key={bed.id} bed={bed} />
                        ))}
                    </div>
                </div>
                <div className="section-container b-left f-1 d-flex collumn">
                    <div className="f-3">    
                        <div className="filter-container">
                            <TextField onChange={searchDoctors} className={classes.root} id="doctors" label="Search Doctors" variant="outlined" size="small" sx={{ minWidth: "80%" }}/>
                        </div>
                        <div className="result-container">
                        {searchDoctor.map(doctor => (
                            <div className="doctor-card" key={doctor.id}>
                                <p>{doctor.name}</p>
                            </div>
                        ))}
                        <div className="doctor-card" >
                                <p>adasd</p>
                            </div>
                            <div className="doctor-card" >
                                <p>adasda</p>
                            </div>
                            <div className="doctor-card" >
                                <p>asdasd</p>
                            </div>
                            <div className="doctor-card" >
                                <p>asdsada</p>
                            </div>
                        </div>
                    </div>
                    <div className="f-3">   
                        <div className="filter-container f-3">
                                <TextField onChange={searchNurses} className={classes.root} id="nurses" label="Search Nurses" variant="outlined" size="small" sx={{ minWidth: "80%" }}/>
                        </div>
                        <div className="result-container">
                            {searchNurse.map(nurse => (
                                <div className="nurse-card" key={nurse.id}>
                                    <p>{nurse.name}</p>
                                </div>
                            ))}
                        </div>
                    </div>
                    <div className="f-3">   
                        <div className="filter-container f-3">
                            <TextField className={classes.root} id="patients" label="Search Patients" variant="outlined" size="small" sx={{ minWidth: "80%" }}/>
                        </div>
                        <div className="result-container">
                            {searchNurse.map(nurse => (
                                <div className="nurse-card" key={nurse.id}>
                                    <p>{nurse.name}</p>
                                </div>
                            ))}
                        </div>
                        
                    </div>
                </div>
            </div>
        </>
    );
};

export default Departments;