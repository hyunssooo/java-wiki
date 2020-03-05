<template>
    <v-container>
        <v-row id="nav">
            <v-col>
                <span id="title">Developer WIKI</span>
            </v-col>
        </v-row>
        <v-row justify="center">
            <SearchBar class="middle"></SearchBar>
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
        color: navajowhite;
        font-size: 5em;
        line-height: 1;
        display: inline-block;
        font-family: 'Roboto Mono', monospace;
    }

    #btn-login {
        color: white;
    }

    .middle {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
    }
</style>