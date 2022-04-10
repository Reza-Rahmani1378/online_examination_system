import {RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {LoginComponent} from "./login/login.component";
import {SignupComponent} from "./signup/signup.component";
import {NgModule} from "@angular/core";
import {AdminWorkbenchComponent} from "./admin/admin-workbench/admin-workbench.component";
import {ProfessorWorkbenchComponent} from "./professor/professor-workbench/professor-workbench.component";
import {StudentWorkbenchComponent} from "./student/student-workbench/student-workbench.component";

const routes: Routes = [

  {path: '', component: HomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'adminWorkBench', component: AdminWorkbenchComponent},
  {path: 'professorWorkBench', component: ProfessorWorkbenchComponent},
  {path: 'studentWorkBench', component: StudentWorkbenchComponent}
]


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
