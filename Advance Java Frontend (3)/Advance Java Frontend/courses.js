let coursesContainer = document.getElementById("coursesContainer");
let role=localStorage.getItem("role")
let addCourseBtn = document.getElementById("addCourseBtn");

if (role == "Admin") {
    addCourseBtn.style.display = "block"; // Show Add Course button
}
let x = fetch("http://localhost:8080/fetchallCourses")
console.log(x);

x.then(response => response.json())
.then(res => {
    console.log(res.data);

    res.data.forEach((obj) => {
        let courseCard = `
            <div class="course">
                <h2><span>${obj.cid}</span>. ${obj.cname}</h2>
                <p>${obj.duration}</p>
                <p>Cost : <b>${obj.cost}</b> Rs/-</p>
        `;

        if (role == "Admin") {
            courseCard += `
                <button onclick="editCourse(${obj.cid})">Edit</button>
                <button onclick="deleteCourse(${obj.cid})">Delete</button>
                <button onclick="showStudents(${obj.cid})">Registered Students</button>
            `
        } else {
            courseCard += `
                <button onclick="fetchCourses(${obj.cid})">ADD</button>
            `
        }

        courseCard += `</div>`
        coursesContainer.innerHTML += courseCard;
    });
})

function editCourse(cid) {
    window.location.href="./editcourse.html";
    localStorage.setItem("cid",cid)
}

function deleteCourse(cid) {
    
       let x= fetch(`http://localhost:8080/deletecourse/${cid}`, {
            method: 'DELETE'
        })
        x.then(response => {
            return (response.json())
    })
        .then(res => {
            alert(res.msg);
            location.reload();
        });
    }
    
function fetchCourses(cid)
{
    let sid = localStorage.getItem("id");
    console.log(sid);
    let x = fetch(`http://localhost:8080/fetchcourses/${sid}`);
    console.log(x);
    x.then(response=>{
        return (response.json());
    })
    .then(res=>{
        console.log(res.data);      //[{},{},{}]
        
        let x = res.data.some(obj=>{        // {name:"html",cost:"",duration,id:1}
            return obj.cid === cid
        })
        console.log(x);
        if(x)
        {
            alert("already present");
        }
        else{
            addCourse(cid);
        }
    })
}
function addCourse(cid)
{   
    // // let addedCourses = fetchCourses();      //[{},{},{}]
    // console.log(addedCourses)
    // let x = addedCourses.some(obj=>{        // {name:"html",cost:"",duration,id:1}
    //     return obj.id === cid
    // })
    // console.log(x);     //
    // if(x)
    // {
    //     alert("Already present")
    // }
    // else{
        console.log(cid);
        let sid = localStorage.getItem("id");
        let x = fetch(`http://localhost:8080/addcourse/${sid}/${cid}`,{
            method : 'PUT'
        })
        console.log(x);
        x.then(response=>{
            return (response.json())
        }).then(res=>{
            alert(res.msg)
        })
    // }
}
function showStudents(cid) {
    let x=fetch(`http://localhost:8080/getStudent/${cid}`)
        x.then(res => {return res.json()})
        .then(res => {
            let students = res.data;
            let studentListDiv = document.getElementById("studentList");
            studentListDiv.innerHTML = ""; 

            if (students.length === 0) {
                studentListDiv.innerHTML = "<p>No students registered for this course.</p>";
            } else {
                students.forEach((student, i) => {
                    studentListDiv.innerHTML += `
                        <div class="student-card">
                            <strong>${i + 1}. ${student.fname} ${student.lname}</strong><br>
                            Email: ${student.email}<br>
                            Address: ${student.address}<br>
                            Mobile: ${student.mobileNumber}
                        </div>
                    `;
                });
            }

            document.getElementById("studentModal").style.display = "block";
        })
        
}

function closeModal() {
    document.getElementById("studentModal").style.display = "none";
}


