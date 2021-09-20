import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment.prod';
import { Usuario } from '../model/Usuario';
import { UsuarioLogin } from '../model/UsuarioLogin';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(
    private http: HttpClient
  ) { }
  token = {
    headers: new HttpHeaders().set('Authorization', environment.token)
  }

  entrar(usuarioLogin: UsuarioLogin): Observable<UsuarioLogin>{
    return this.http.post<UsuarioLogin>('http://localhost:8443/usuarios/logar', usuarioLogin)
  }

  cadastrar(usuario:Usuario):Observable<Usuario>{
    return this.http.post<Usuario>('http://localhost:8443/usuarios/cadastrar', usuario)

  }

  getAllUsuarios(): Observable<Usuario[]>{
    return this.http.get<Usuario[]>(`http://localhost:8443/usuarios/`)
  }

  getByIdUsuario(id: number): Observable<Usuario>{
    return this.http.get<Usuario>(`http://localhost:8443/usuarios/${id}`)
  }


  logado(){
    let ok:boolean = false

    if (environment.token != ''){
      ok = true
    }


    return ok
  }



  atualizar(usuario: Usuario):Observable<Usuario>{
    return this.http.put<Usuario>('http://localhost:8443/usuarios/', usuario)
    }



}