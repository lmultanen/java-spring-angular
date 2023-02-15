import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Student } from "./student";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class StudentService {
    private apiServerUrl = '';

    constructor(private http: HttpClient) {}

    public getStudents(): Observable<Student[]> {
        return this.http.get<Student[]>(`${this.apiServerUrl}/student/all`);
    }

    public addStudent(student: Student): Observable<Student> {
        return this.http.post<Student>(`${this.apiServerUrl}/student/add`, student);
    }

    public updateStudent(student: Student): Observable<Student> {
        return this.http.put<Student>(`${this.apiServerUrl}/student/update`, student);
    }

    public deleteStudent(studentId: number): Observable<void> {
        return this.http.delete<void>(`${this.apiServerUrl}/student/${studentId}/delete`);
    }
} 