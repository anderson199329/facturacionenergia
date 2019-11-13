import { RespuestaData } from "./respuestaData";
import { EstadoRespuesta } from "./estadoRespuesta";
import { InformacionServicio } from "./informacionServicio";

export class RespuestaDataList{

    respuestaData:RespuestaData;
    estadoRespuesta:EstadoRespuesta;
    informacionServicio:InformacionServicio;

    constructor(respuestaData:RespuestaData, estadoRespuesta:EstadoRespuesta, informacionServicio:InformacionServicio){

        this.respuestaData = respuestaData;
        this.estadoRespuesta = estadoRespuesta;
        this.informacionServicio = informacionServicio;

    }

}