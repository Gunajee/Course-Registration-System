function showCourses() {
  fetch("http://localhost:8080/courses")
    .then((response) => response.json())
    .then((courses) => {
      const dataTable = document.getElementById("coursetable");

      courses.forEach((course) => {
        var row = `<tr>
                <td>${course.courseId}</td>
                <td>${course.courseName}</td>
                <td>${course.trainer}</td>
                <td>${course.durationInWeek}</td>
                </tr>`;
        dataTable.innerHTML += row;
      });
    });
}
function showEnrolledStudents() {
  fetch("http://localhost:8080/courses/enrolled")
    .then((response) => response.json())
    .then((enrolledStudents) => {
      const dataTable = document.getElementById("enrolledtable");

      enrolledStudents.forEach((student) => {
        var row = `<tr>
                <td>${student.name}</td>
                <td>${student.emailId}</td>
                <td>${student.courseName}</td>
                </tr>`;
        dataTable.innerHTML += row;
      });
    });
}
// function getAvailableCourses() {
//   fetch("http://localhost:8080/courses")
//     .then((response) => response.json())
//     .then((courses) => {
//       const listOption = document.getElementById("availableCourses");

//       courses.forEach((course) => {
//         var option = `<option value=${course.courseName}>
//           ${course.courseName}
//                 </option>`;
//         listOption.append(option);
//       });
//     });
// }
function getAvailableCourses() {
  const listOption = document.getElementById("course");

  if (!listOption) {
    console.error("Error: Element with id 'availableCourses' not found!");
    return;
  }

  fetch("http://localhost:8080/courses")
    .then((response) => response.json())
    .then((courses) => {
      listOption.innerHTML = ""; // Clear previous options

      courses.forEach((course) => {
        let option = document.createElement("option");
        option.value = course.courseName;
        option.textContent = course.courseName;
        listOption.appendChild(option);
      });
    })
    .catch((error) => console.error("Error fetching courses:", error));
}

document.addEventListener("DOMContentLoaded", function () {
  getAvailableCourses();
});
