import java.util.List;

public class Medico extends Persona{
	// Atributos
	
	String especialidad;
	String area;
	List<Paciente> pacientes;
	
	public Medico() {
		super();
	}
	
	public Medico(String nombre, String apellido, int edad, String genero, String especialidad, String area, List<Paciente> pacientes) {
		super(nombre, apellido, edad, genero);
		this.especialidad = especialidad;
		this.area = area;
		this.pacientes = pacientes;
	}
	
	@Override
	public String toString() {
		return "Médico =>[Nombre:" + nombre + ", Apellido:" + apellido + ", Edad:" + edad + ", Género:" + genero + ", Especialidad:"
				+ especialidad + "," + " Área:" + area + ", \nPacientes:\n" + (pacientes.size() == 0 ? "Sin pacientes" : pacientes) + "\n";
	}
	
	public String getEspecialidad() {
		return especialidad;
	}
	
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	
}
