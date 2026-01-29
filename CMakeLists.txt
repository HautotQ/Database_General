cmake_minimum_required(VERSION 3.16)

set(CMAKE_SYSTEM_NAME Generic)
set(CMAKE_C_COMPILER arm-none-eabi-gcc)

project(mon_projet C)
set(CMAKE_C_STANDARD 11)

if(NOT DEFINED ENV{DEVKITPRO})
    message(FATAL_ERROR "DEVKITPRO n'est pas défini")
endif()

set(DEVKITPRO $ENV{DEVKITPRO})
set(LIBCTRU ${DEVKITPRO}/libctru)

set(ARCH_FLAGS "-march=armv6k -mtune=mpcore -mfloat-abi=hard -mtp=soft")

add_executable(mon_projet
    src/main.c
)

target_compile_options(mon_projet PRIVATE
    ${ARCH_FLAGS}
    -Wall -O2
)

target_include_directories(mon_projet PRIVATE
    ${LIBCTRU}/include
)

target_link_directories(mon_projet PRIVATE
    ${LIBCTRU}/lib
)

target_link_libraries(mon_projet
    ctru
    m
)

add_custom_command(TARGET mon_projet POST_BUILD
    COMMAND ${DEVKITPRO}/tools/bin/3dsxtool
        $<TARGET_FILE:mon_projet>
        ${CMAKE_CURRENT_BINARY_DIR}/mon_projet.3dsx
)
