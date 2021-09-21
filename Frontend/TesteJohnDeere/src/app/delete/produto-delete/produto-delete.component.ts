import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Categoria } from 'src/app/model/Categoria';
import { AlertasService } from 'src/app/service/alertas.service';
import { CategoriaService } from 'src/app/service/categoria.service';
import { environment } from 'src/environments/environment.prod';

@Component({
  selector: 'app-produto-delete',
  templateUrl: './produto-delete.component.html',
  styleUrls: ['./produto-delete.component.css']
})
export class ProdutoDeleteComponent implements OnInit {

  categoria: Categoria = new Categoria
  idCategoria: number

  constructor(
    private router: Router,
    private categoriaService: CategoriaService,
    private route: ActivatedRoute,
    private alertas: AlertasService
  ) {}


  ngOnInit(){
    if (environment.token == ''){
      alert('Sua sessão expirou')
      this.router.navigate(['/entrar'])
    }

    this.idCategoria = this.route.snapshot.params['id']
    this.findByIdCategoria(this.idCategoria)
  }

  findByIdCategoria(id:number){
    this.categoriaService.getByIdCategoria(id).subscribe((resp:Categoria)=>{
      this.categoria = resp
    })
    }

  apagar(){
    this.categoriaService.deleteCategoria(this.idCategoria).subscribe(()=>{
      this.alertas.showAlertSuccess('Categoria apagada com sucesso.')
      this.router.navigate(['/categorias'])
    })
  }

}
