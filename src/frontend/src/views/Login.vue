<template>
    <div class="middle">
        <a :href="'http://' + host + '/login/kakao'">
            <img alt="kakao_login" class="logo" src="../assets/img/kakao_account_login_btn_medium_narrow.png">
        </a>
        <a :href="'http://' + host + '/login/github'">
            <img alt="github_login" class="logo" src="../assets/img/github_login_btn.png">
        </a>
    </div>
</template>

<script>
    export default {
        name: "Login",
        data() {
            return {
                host: location.host
            }
        }
    }
</script>

<style scoped>
    .logo {
        margin-left: auto;
        margin-right: auto;
        display: block;
    }

    .middle {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
    }
</style>