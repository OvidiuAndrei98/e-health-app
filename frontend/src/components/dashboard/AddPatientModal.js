import React, {useEffect} from 'react';
import TextField from '@mui/material/TextField';
import Typography from '@mui/material/Typography';
import {useForm} from 'react-hook-form';
import { makeStyles } from '@mui/styles';
import Button from '@mui/material/Button';
import Autocomplete from '@mui/material/Autocomplete';
import DoctorService from '../../service/DoctorService';
import NurseService from '../../service/NurseService';
import PatientService from '../../service/PatientService';
import BedService from '../../service/BedService';

const AddPatientModal = ({bed,closeModal}) => {
const [doctors, setDoctors] = React.useState([]);
const [nurses, setNurses] = React.useState([]);
const [patientDoctor, setPatientDoctor] = React.useState(null);
const [patientNurse, setPatientNurse] = React.useState(null);
const { register, handleSubmit, formState: {errors} } = useForm();

const useStyles = makeStyles((theme) => ({
    root: {
        height: 50,
          "& .MuiInputLabel-root.Mui-focused": {
            color: "#798BF2"
          },
          "& .MuiOutlinedInput-root.Mui-focused .MuiOutlinedInput-notchedOutline": {
            borderColor: "#798BF2",
          },
          "& .MuiInputBase-root": {
            height:"50px",
          }
      },
  }));

  const classes = useStyles();

  const handleSelectDoctor = (value) => {
     setPatientDoctor(value);
}

const handleSelectNurse = (value) => {
    setPatientNurse(value);
}

const searchDoctors= () => {
    DoctorService.getAllDoctors().then(res => { 
        setDoctors(res.data);
    });
}

const searchNurses= () => {
    NurseService.getAllNurses().then(res => { 
        setNurses(res.data);
    });
}

    return (
        <>
        <form noValidate onSubmit={
                        handleSubmit((data) => {
                            BedService.addPatient(data,bed.id).then(res => {
                                console.log("SAVED");
                            });
                            }
                        )
                        }>
        <div className="modal-box">
        <TextField className={classes.root} id="name" label="Name" variant="outlined" size="small" sx={{ minWidth: "100%" }}
            {...register("name", {required: true})}/>
        </div>
        <div className="modal-box">
        <TextField className={classes.root} id="age" label="Age" variant="outlined" size="small" sx={{ minWidth: "100%" }}
            {...register("age", {required: true})}/>
        </div>
        <div className="modal-box">
        <TextField className={classes.root} id="sex" label="Gender" variant="outlined" size="small" sx={{ minWidth: "100%" }}
            {...register("sex", {required: true})}/>
        </div>
        <div className="modal-box">
        <TextField className={classes.root} id="diagnosis" label="Diagnosis" variant="outlined" size="small" sx={{ minWidth: "100%" }}
            {...register("diagnosis", {required: true})}/>
        </div>
        <div className="modal-box">
        <TextField type="date" className={classes.root} id="admissionDate"  variant="outlined" size="small" sx={{ minWidth: "100%" }}
            {...register("admissionDate", {required: true})}/>
        </div>
        <div className="modal-box">
        <TextField className={classes.root} id="phoneNumber" label="Phone" variant="outlined" size="small" sx={{ minWidth: "100%" }}
            {...register("phoneNumber", {required: true})}/>
        </div>
        <div className="modal-box">
        <TextField className={classes.root} id="notes" label="Notes" variant="outlined" size="small" sx={{ minWidth: "100%" }}
            {...register("notes", {required: true})}/>
        </div>
        <div className="modal-box">
        <Autocomplete
                    disablePortal
                    id="searchDoctors"
                    getOptionLabel={(option) => option.name}
                    options={doctors}
                    onChange={(event, value) => {handleSelectDoctor(value); console.log(value)}}
                    sx={{ width: "100%" }}
                    value={patientDoctor}
                    renderInput={(params) => 
                    <TextField className={classes.root} onChange={searchDoctors}  sx={{ minWidth: "100%" }} size="small" {...params} label="Search Doctor"/>
                    }/>
        </div>
        <div className="modal-box">
        <Autocomplete
                    disablePortal
                    id="searchNurse"
                    getOptionLabel={(option) => option.name}
                    options={nurses}
                    onChange={(event, value) => {handleSelectNurse(value); console.log(value)}}
                    sx={{ width: "100%" }}
                    value={patientNurse}
                    renderInput={(params) => 
                    <TextField className={classes.root} onChange={searchNurses} sx={{ minWidth: "100%" }} size="small" {...params} label="Search Nurse"/>
                    }/>
        </div>
        <div style={{display:"flex", flexDirection:"row", justifyContent:"space-between", alignItems:"center"}}>
        <Button type="submit" style={{background:"#F27457"}} variant="contained" sx={{borderRadius:"5px", padding:"10px 5px", height:"0", marginTop:"20px", float:"right", marginBottom:"0"}}>Save Changes</Button>        
        </div>
        </form>
        </>
    );
};

export default AddPatientModal;