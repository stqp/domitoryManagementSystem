<template>
  <div class="container">
    <div class="my-3 text-justify">
      <div class="modal fade" id="addBuildingModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">追加</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <div class="container form-group row">
                <label for="building-name" class="col-sm-3 col-form-label">建物名</label>
                <div class="col-sm-9">
                  <input type="text" id="building-name" v-model="buildingName" class="form-control">
                </div>
              </div>
            </div>
            <div class="modal-footer justify-content-center">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">戻る</button>
              <button type="button" class="btn btn-primary" v-on:click="addBuilding">保存</button>
            </div>
          </div>
        </div>
      </div>
      <button
          type="button"
          class="btn btn-primary btn-sm"
          data-toggle="modal"
          data-target="#addBuildingModal">
        新規追加
      </button>
      <button
          type="button"
          class="btn btn-danger btn-sm ml-3"
          data-toggle="modal"
          data-target="">
        削除
      </button>
    </div>

    <ul class="list-group text-justify">
      <li class="list-group-item">Cras justo odio</li>
      <li class="list-group-item">Dapibus ac facilisis in</li>
      <li class="list-group-item">Morbi leo risus</li>
      <li class="list-group-item">Porta ac consectetur ac</li>
      <li class="list-group-item">Vestibulum at eros</li>
    </ul>
  </div>
</template>

<script>

export default {
  name: "Building",
  data() {
    return {
      buildingName: '',
    }
  },
  methods: {
    addBuilding() {

      // this.$store
      //     .dispatch(ADD_BUILDING, {email, password})
      //     .then(() => this.$router.push({name: "home"}));
    }
  }
}
</script>

<style scoped>

</style>