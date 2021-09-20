import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastrarComponent } from './cadastrar/cadastrar.component';
import { CategoriasComponent } from './categorias/categorias.component';
import { CategoriaDeleteComponent } from './delete/categoria-delete/categoria-delete.component';
import { ProdutoDeleteComponent } from './delete/produto-delete/produto-delete.component';
import { CategoriaEditComponent } from './edit/categoria-edit/categoria-edit.component';
import { ProdutoEditComponent } from './edit/produto-edit/produto-edit.component';
import { UsuarioEditComponent } from './edit/usuario-edit/usuario-edit.component';
import { EntrarComponent } from './entrar/entrar.component';
import { HomeComponent } from './home/home.component';
import { ProdutoComponent } from './produto/produto.component';

const routes: Routes = [
  {path: '' , redirectTo:'entrar', pathMatch: 'full'},

  {path: 'entrar', component:EntrarComponent },
  {path: 'cadastrar', component: CadastrarComponent},
  {path: 'home', component: HomeComponent},
  {path: 'categorias', component: CategoriasComponent},
  {path: 'produto/:id', component: ProdutoComponent},
  {path: 'categoria-edit/:id', component: CategoriaEditComponent},
  {path: 'categoria-delete/:id', component: CategoriaDeleteComponent},
  {path: 'produto-edit/:id', component: ProdutoEditComponent},
  {path: 'produto-delete/:id', component: ProdutoDeleteComponent},
  {path: 'usuario-edit/:id' , component: UsuarioEditComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
