package com.for_loop.alquilatusvehiculos.config;

import com.for_loop.alquilatusvehiculos.model.Alquiler;
import com.for_loop.alquilatusvehiculos.model.Cliente;
import com.for_loop.alquilatusvehiculos.model.Sede;
import com.for_loop.alquilatusvehiculos.model.Vehiculo;
import com.for_loop.alquilatusvehiculos.repository.AlquilerRepository;
import com.for_loop.alquilatusvehiculos.repository.ClienteRepository;
import com.for_loop.alquilatusvehiculos.repository.SedeRepository;
import com.for_loop.alquilatusvehiculos.repository.VehiculoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(ClienteRepository clienteRepository,
                                      SedeRepository sedeRepository,
                                      VehiculoRepository vehiculoRepository,
                                      AlquilerRepository alquilerRepository,
                                      PasswordEncoder passwordEncoder) {
        return args -> {
            long count = clienteRepository.count();
            System.out.println(">>> COUNT CLIENTES: " + count);
            if (count == 0) {
                System.out.println(">>> INSERTANDO DATOS...");

                if (clienteRepository.count() == 0) {

                    // Sedes
                    Sede central = new Sede();
                    central.setNombre("Central");
                    central.setCiudad("Barcelona");
                    central.setDireccion("Carrer Mallorca, 12");
                    central.setTelefono("+34932000001");
                    sedeRepository.save(central);

                    Sede aeroport = new Sede();
                    aeroport.setNombre("Aeroport El Prat");
                    aeroport.setCiudad("El Prat");
                    aeroport.setDireccion("Terminal T1, Nivell -1");
                    aeroport.setTelefono("+34932000002");
                    sedeRepository.save(aeroport);

                    Sede nord = new Sede();
                    nord.setNombre("Area Nord");
                    nord.setCiudad("Sabadell");
                    nord.setDireccion("Av. de les Bases, 32");
                    nord.setTelefono("+34932000003");
                    sedeRepository.save(nord);

                    // Vehiculos
                    Vehiculo v1 = new Vehiculo();
                    v1.setMatricula("1234 ABC");
                    v1.setMarca("Toyota");
                    v1.setModelo("Corolla");
                    v1.setTipo(Vehiculo.TipoVehiculo.COCHE);
                    v1.setAnio(2021);
                    v1.setPrecioDia(42.00);
                    v1.setEstado(Vehiculo.EstadoVehiculo.DISPONIBLE);
                    vehiculoRepository.save(v1);

                    Vehiculo v2 = new Vehiculo();
                    v2.setMatricula("5839 ASC");
                    v2.setMarca("Honda");
                    v2.setModelo("CB500");
                    v2.setTipo(Vehiculo.TipoVehiculo.MOTO);
                    v2.setAnio(2020);
                    v2.setPrecioDia(28.00);
                    v2.setEstado(Vehiculo.EstadoVehiculo.DISPONIBLE);
                    vehiculoRepository.save(v2);

                    Vehiculo v3 = new Vehiculo();
                    v3.setMatricula("5212 JLM");
                    v3.setMarca("Ford");
                    v3.setModelo("Transit");
                    v3.setTipo(Vehiculo.TipoVehiculo.FURGONETA);
                    v3.setAnio(2022);
                    v3.setPrecioDia(65.00);
                    v3.setEstado(Vehiculo.EstadoVehiculo.ALQUILADO);
                    vehiculoRepository.save(v3);

                    // Clientes
                    Cliente c1 = new Cliente();
                    c1.setNombre("Carlos");
                    c1.setApellidos("Garcia Saez");
                    c1.setDni("41299191K");
                    c1.setEmail("cgarcia@mail.com");
                    c1.setTelefono("+34654221021");
                    c1.setDireccion("Carrer del Consell, 14, Barcelona");
                    c1.setFechaRegistro(LocalDate.of(2025, 1, 12));
                    c1.setPassword(passwordEncoder.encode("password123"));
                    c1.setRol(Cliente.RolUsuario.USER);
                    clienteRepository.save(c1);

                    Cliente c2 = new Cliente();
                    c2.setNombre("Maria");
                    c2.setApellidos("Aritz Soler");
                    c2.setDni("32187654B");
                    c2.setEmail("maritz@mail.com");
                    c2.setTelefono("+34612440882");
                    c2.setDireccion("Av. Diagonal, 32, Barcelona");
                    c2.setFechaRegistro(LocalDate.of(2025, 1, 28));
                    c2.setPassword(passwordEncoder.encode("password123"));
                    c2.setRol(Cliente.RolUsuario.USER);
                    clienteRepository.save(c2);

                    Cliente admin = new Cliente();
                    admin.setNombre("Andreu");
                    admin.setApellidos("Cavaneres Pla");
                    admin.setDni("55034812C");
                    admin.setEmail("andreu.c@mail.com");
                    admin.setTelefono("+34699103774");
                    admin.setDireccion("Carrer Major, 5, Sabadell");
                    admin.setFechaRegistro(LocalDate.of(2025, 2, 3));
                    admin.setPassword(passwordEncoder.encode("password123"));
                    admin.setRol(Cliente.RolUsuario.ADMIN);
                    clienteRepository.save(admin);


                    // Alquileres
                    Alquiler a1 = new Alquiler();
                    a1.setFechaInicio(LocalDate.of(2026, 3, 10));
                    a1.setFechaFin(LocalDate.of(2026, 3, 12));
                    a1.setPrecioTotal(84.00);
                    a1.setEstado(Alquiler.EstadoAlquiler.ACTIVO);
                    a1.setCliente(c1);
                    a1.setVehiculo(v1);
                    a1.setSedeRecogida(central);
                    a1.setSedeDevolucion(central);
                    alquilerRepository.save(a1);

                    Alquiler a2 = new Alquiler();
                    a2.setFechaInicio(LocalDate.of(2026, 3, 11));
                    a2.setFechaFin(LocalDate.of(2026, 3, 17));
                    a2.setPrecioTotal(252.00);
                    a2.setEstado(Alquiler.EstadoAlquiler.PENDIENTE);
                    a2.setCliente(c2);
                    a2.setVehiculo(v2);
                    a2.setSedeRecogida(nord);
                    a2.setSedeDevolucion(aeroport);
                    alquilerRepository.save(a2);

                    Alquiler a3 = new Alquiler();
                    a3.setFechaInicio(LocalDate.of(2026, 3, 1));
                    a3.setFechaFin(LocalDate.of(2026, 3, 8));
                    a3.setPrecioTotal(280.00);
                    a3.setEstado(Alquiler.EstadoAlquiler.FINALIZADO);
                    a3.setCliente(c1);
                    a3.setVehiculo(v3);
                    a3.setSedeRecogida(central);
                    a3.setSedeDevolucion(central);
                    alquilerRepository.save(a3);
                }
            }

        };
    }
}