// import React, {useEffect} from 'react';
// import TextField from '@mui/material/TextField';
// import Typography from '@mui/material/Typography';
// import {useForm} from 'react-hook-form';
// import { makeStyles } from '@mui/styles';
// import Button from '@mui/material/Button';
// import Autocomplete from '@mui/material/Autocomplete';
// import DoctorService from '../../service/DoctorService';
// import NurseService from '../../service/NurseService';
// import PatientService from '../../service/PatientService';

// const DoctorDetailsModal = ({doctor}) => {

// const useStyles = makeStyles((theme) => ({
//     root: {
//         height: 50,
//           "& .MuiInputLabel-root.Mui-focused": {
//             color: "#798BF2"
//           },
//           "& .MuiOutlinedInput-root.Mui-focused .MuiOutlinedInput-notchedOutline": {
//             borderColor: "#798BF2",
//           },
//           "& .MuiInputBase-root": {
//             height:"50px",
//           }
//       },
//   }));

//   const classes = useStyles();

//     return (
//         <>
//         <div className="modal-box d-flex row justify-between" >
//             <p>Patient id: {bed.patient.id}</p>
//             <p>Room nr: {bed.room.id}</p>
//             <p>Bed nr: {bed.id}</p>
//         </div>
//         <form noValidate onSubmit={
//                         handleSubmit((data) => {
//                             PatientService.savePatient(data,bed.patient.id, patientDoctor, patientNurse);
//                             // closeModal(false)
//                             }
//                         )
//                         }>
//         <div className="modal-box">
//         <TextField className={classes.root} id="name" defaultValue={bed.patient.name} label="Name" variant="outlined" size="small" sx={{ minWidth: "100%" }}
//             {...register("name", {required: true})}/>
//         </div>
//         <div className="modal-box">
//         <TextField className={classes.root} id="age" defaultValue={bed.patient.age} label="Age" variant="outlined" size="small" sx={{ minWidth: "100%" }}
//             {...register("age", {required: true})}/>
//         </div>
//         <div className="modal-box">
//         <TextField className={classes.root} id="sex" defaultValue={bed.patient.sex} label="Gender" variant="outlined" size="small" sx={{ minWidth: "100%" }}
//             {...register("sex", {required: true})}/>
//         </div>
//         <div className="modal-box">
//         <TextField className={classes.root} id="diagnosis" defaultValue={bed.patient.diagnosis} label="Diagnosis" variant="outlined" size="small" sx={{ minWidth: "100%" }}
//             {...register("diagnosis", {required: true})}/>
//         </div>
//         <div className="modal-box">
//         <TextField type="date" className={classes.root} id="admissionDate" defaultValue={`${bed.patient.admissionDate[0]}-${bed.patient.admissionDate[1]}-${bed.patient.admissionDate[2]}`}  variant="outlined" size="small" sx={{ minWidth: "100%" }}
//             {...register("admissionDate", {required: true})}/>
//         </div>
//         <div className="modal-box">
//         <TextField className={classes.root} id="phoneNumber" defaultValue={bed.patient.phoneNumber} label="Phone" variant="outlined" size="small" sx={{ minWidth: "100%" }}
//             {...register("phoneNumber", {required: true})}/>
//         </div>
//         <div className="modal-box">
//         <TextField className={classes.root} id="notes" defaultValue={bed.patient.notes} label="Notes" variant="outlined" size="small" sx={{ minWidth: "100%" }}
//             {...register("notes", {required: true})}/>
//         </div>
//         <div className="modal-box">
//         <Autocomplete
//                     disablePortal
//                     id="searchDoctors"
//                     getOptionLabel={(option) => option.name}
//                     options={doctors}
//                     onChange={(event, value) => {handleSelectDoctor(value); console.log(value)}}
//                     sx={{ width: "100%" }}
//                     value={patientDoctor}
//                     renderInput={(params) => 
//                     <TextField className={classes.root} onChange={searchDoctors}  sx={{ minWidth: "100%" }} size="small" {...params} label="Search Doctor"/>
//                     }/>
//         </div>
//         <div className="modal-box">
//         <Autocomplete
//                     disablePortal
//                     id="searchNurse"
//                     getOptionLabel={(option) => option.name}
//                     options={nurses}
//                     onChange={(event, value) => {handleSelectNurse(value); console.log(value)}}
//                     sx={{ width: "100%" }}
//                     value={patientNurse}
//                     renderInput={(params) => 
//                     <TextField className={classes.root} onChange={searchNurses} sx={{ minWidth: "100%" }} size="small" {...params} label="Search Nurse"/>
//                     }/>
//         </div>
//         <div style={{display:"flex", flexDirection:"row", justifyContent:"space-between", alignItems:"center"}}>
//         <p className="delete-btn">Delete patient</p>
//         <Button type="submit" style={{background:"#F27457"}} variant="contained" sx={{borderRadius:"5px", padding:"10px 5px", height:"0", marginTop:"20px", float:"right", marginBottom:"0"}}>Save Changes</Button>        
//         </div>
//         </form>
//         </>
//     );
// };

// export default PatientDetailsModal;