import React, { useEffect, useState } from 'react';
import {Table} from 'antd';
import {useNavigate} from "react-router-dom";
// import "../style/GetUser.css"
export default function GetUser(){
  
    const navigate = useNavigate();
    const coloumns=[
        {

            title:"Email-id",
            dataIndex:"emailid",
            
        },
        {
            title:"First Name",
            dataIndex:"fname"
        },
        {

            title:"Last Name",
            dataIndex:"lname",
            
        },
        {
            title:"Mobile Number",
            dataIndex:"mbno"
        },
        {

            title:"DOB",
            dataIndex:"dob",
            
        },
        {
            title:"Address",
            dataIndex:"address"
        },
        {
            title: "Update",
            render: (res) => (
                <button onClick={()=>navigate(`/put/${res.emailid}`)}> Edit </button>
            ),
        },
        {
            title:"Delete",
            render:(res)=>(<button onClick={()=>handleDelete(res.emailid)}>Delete</button>
            )
        }
        

    ];

    const[emp,setEmp]=useState([]);
    useEffect(()=>{
        fetch("http://localhost:8080/divumemp/fetch")
        .then((res)=>res.json())
        .then((result)=>{
            const rev = result.reverse();
            setEmp(rev);
        });
    },[]);

    const handleDelete= (record)=>{
        console.log("Email: "+record);
        const confirmDelete= window.confirm("Are You Sure to Delete the record");
        if(confirmDelete){
            fetch(`http://localhost:8080/divumemp/delete/${record}`,{method: "DELETE",})
            .then(()=>window.location.reload());
        }
    };

    return(
        <>
        <div className="table">
       
         <h1>Employee Details</h1>
         <Table id="innertable" columns={coloumns} dataSource={emp}></Table>
         <button onClick={()=>navigate('/add')} id="button" data-testid="adduserbtn"> Add User </button>
        </div>
         
        
        </>
    );
    

   

}