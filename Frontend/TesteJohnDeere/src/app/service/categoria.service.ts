import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Categoria } from '../model/Categoria';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService {

  constructor(private http: HttpClient) { }

  token = {
    headers: new HttpHeaders().set('Authorization', environment.token)
  }
  getAllCategoria(): Observable<Categoria[]>{
    return this.http.get<Categoria[]>('http://localhost:8443/categoria')
  }

  getByIdCategoria(id: number):Observable<Categoria>{
    return this.http.get<Categoria>(`http://localhost:8443/categoria/${id}`)

  }

  postCategoria(categoria: Categoria): Observable<Categoria>{
    return this.http.post<Categoria>('http://localhost:8443/categoria', categoria)
  }

  putCategoria(categoria: Categoria): Observable<Categoria>{
    return this.http.put<Categoria>('http://localhost:8443/categoria', categoria)
  }

  deleteCategoria(id:number){
    return this.http.delete<Categoria>(`http://localhost:8443/categoria/${id}`)
  }
}
