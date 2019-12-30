<template>
    <v-app id="app">
        <router-view/>
    </v-app>
</template>

<script>

    export default {
        name: 'App',

        data: () => ({
            //
        }),
    };
</script>

<style>
    #app {
        background-image: url('assets/img/bg_planet.jpg');
        background-repeat: no-repeat;
        background-size: cover;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        height: 100%;
    }
</style>