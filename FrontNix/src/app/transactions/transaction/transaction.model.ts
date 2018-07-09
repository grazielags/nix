import {Usuario} from './user.model'

export class Transferencia {
  id: number
  usuario: Usuario
  pagadorNome: string
  pagadorBanco: string
  pagadorAgencia: string
  pagadorConta: string
  beneficiarioNome: string
  beneficiarioBanco: string
  beneficiarioAgencia: string
  beneficiarioConta: string
  valor: number
  tipo: string
  status: string
}
