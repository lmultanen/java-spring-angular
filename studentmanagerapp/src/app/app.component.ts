import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Student } from './student';
import { StudentService } from './student.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public students: Student[];
  public updateStudent: Student | undefined;
  public deleteStudent: Student | undefined;
  public editStudent: Student | undefined;

  constructor(private studentService: StudentService) {}

  ngOnInit(): void {
      this.getStudents();
  }

  public getStudents(): void {
    this.studentService.getStudents().subscribe(
      {
        next: ((response: Student[]) => {
            this.students = response;
          }),
        error: (error: HttpErrorResponse) => {
          alert(error.message);
        }
      }
    )
  }

  public onAddStudent(addForm: NgForm): void {
    this.studentService.addStudent(addForm.value).subscribe(
      {
        next: (response: Student) => {
          console.log(response);
          this.getStudents();
          addForm.reset();
          document.getElementById("add-student-form")?.click();
        },
        error: (error: HttpErrorResponse) => {
          alert(error.message);
        }
      }
    )
  }

  public onUpdateStudent(student: Student): void {
    this.studentService.updateStudent(student).subscribe(
      {
        next: ((response: Student) => {
            console.log(response);
            this.getStudents();
          }),
        error: (error: HttpErrorResponse) => {
          alert(error.message);
        }
      }
    )
  }

  public onDeleteStudent(id?: number): void {

  }

  public onOpenModal(student: Student | undefined, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.style.display = 'none';
    button.type = 'button';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addStudentModal');
    }
    if (mode === 'edit') {
      this.editStudent = student;
      button.setAttribute('data-target', '#updateStudentModal');
    }
    if (mode === 'delete') {
      this.deleteStudent = student;
      button.setAttribute('data-target', '#deleteStudentModal');
    }
    container?.appendChild(button);
    button.click();
  }
}
