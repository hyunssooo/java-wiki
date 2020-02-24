<template>
    <v-container>
        <v-row id="nav">
            <v-col cols="2" id="home">
                <router-link to="/">
                    <img id="btn-home" src="../assets/img/logo_full_white.png" alt="Logo">
                </router-link>
            </v-col>
            <v-col cols="11">
                <span id="title">WIKI</span>
            </v-col>
            <v-col cols="1">
                <router-link to="/login">
                    <v-btn id="btn-login" text large>로그인</v-btn>
                </router-link>
            </v-col>
            <v-col cols="1">
                <router-link to="/signup">
                    <v-btn id="btn-signup" text large>가입</v-btn>
                </router-link>
            </v-col>
        </v-row>
        <v-row justify="center">
            <SearchBar></SearchBar>
        </v-row>
    </v-container>
</template>

<script>
    import SearchBar from "../components/SearchBar";

    export default {
        name: "home",
        components: {SearchBar}
    }
</script>

<style scoped>
    #nav {
        padding: 30px;
        max-height: 30%;
    }

    #home {
        display: unset;
        float: left;
        position: fixed;
    }

    #btn-home {
        width: 200px;
    }

    #title {
        color: lightyellow;
        font-size: 5em;
        line-height: 1;
        display: inline-block;
        margin-left: 100px;
    }

    #btn-login {
        color: white;
    }
</style>