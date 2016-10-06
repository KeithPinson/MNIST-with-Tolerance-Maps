
#
#

cmake_minimum_required(VERSION 3.4.1)

set(CMAKE_VERBOSE_MAKEFILE on)

set(lib_src_DIR ${CMAKE_SOURCE_DIR}/../../../../libsrc)
set(lib_build_DIR $ENV{HOME}/tmp)
file(MAKE_DIRECTORY ${lib_build_DIR})

# configure import libs
set(distribution_DIR ${CMAKE_SOURCE_DIR}/../../../../distribution)
#LINK_DIRECTORIES(${distribution_DIR}/gmath/lib/${ANDROID_ABI})

add_library(lib_gmath STATIC IMPORTED )
set_target_properties(lib_gmath PROPERTIES IMPORTED_LOCATION
    ${distribution_DIR}/gmath/lib/${ANDROID_ABI}/libgmath.a)

# add the shared libraries to the apk
add_library(lib_lua SHARED IMPORTED )
set_target_properties(lib_lua PROPERTIES IMPORTED_LOCATION
    ${distribution_DIR}/lua/lib/${ANDROID_ABI}/liblua.so)

# add_library(lib_torch SHARED IMPORTED )
# set_target_properties(lib_torch PROPERTIES IMPORTED_LOCATION
#     ${distribution_DIR}/torch/lib/${ANDROID_ABI}/libtorch.so)

# build application's shared lib
include_directories(${distribution_DIR}/lua/include
                    ${distribution_DIR}/torch/include)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11")
# add_library(mnist-torch SHARED mnist-torch.cpp)
## target_link_libraries(mnist-torch log android lib_lua lib_torch)
# target_link_libraries(mnist-torch log android lib_lua)
