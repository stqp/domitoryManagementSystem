<template>
  <div class="container">
    <div class="my-3 text-justify">

      <div class="modal fade" id="addBuildingModal" tabindex="-1">
        <div class="modal-dialog modal-lg">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">新規追加</h5>
              <button id="closeModalButton" type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <div class="container form-group row">
                <label class="col-sm-3 col-form-label">建物名</label>
                <div class="col-sm-9">
                  <input type="text" v-model="newBuilding.name" class="form-control">
                </div>
              </div>
              <div class="container form-group row">
                <label class="col-sm-3 col-form-label">建物の階層数</label>
                <div class="col-sm-9">
                  <input type="number" v-model="newBuilding.topFloorLevel" class="form-control">
                </div>
              </div>
              <div class="container form-group row justify-content-end">
                <button class="btn btn-primary btn-sm"
                        v-on:click="newBuilding.rooms.push({});newBuilding.countOfRooms += 1">
                  部屋追加
                </button>
              </div>
              <div class="container form-group row">
                <table class="table table-bordered">
                  <thead>
                  <tr>
                    <th>階層</th>
                    <th>部屋名</th>
                    <th>収容人数</th>
                    <th>面積</th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr v-for="index in newBuilding.countOfRooms" v-bind:key="index">
                    <td>
                      <select class="form-control" v-model="newBuilding.rooms[index-1].floorLevel">
                        <option v-for="level in parseInt(newBuilding.topFloorLevel)" v-bind:key="level">{{ level }}
                        </option>
                      </select>
                    </td>
                    <td><input class="form-control" type="text" v-model="newBuilding.rooms[index-1].name"></td>
                    <td><input class="form-control" type="number" v-model="newBuilding.rooms[index-1].capacity"></td>
                    <td><input class="form-control" type="number" v-model="newBuilding.rooms[index-1].squareMeters">
                    </td>
                  </tr>
                  </tbody>
                </table>
              </div>

            </div>
            <div class="modal-footer justify-content-center">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">戻る</button>
              <button type="button" class="btn btn-primary" v-on:click="addBuilding(newBuilding)">保存</button>
            </div>
          </div>
        </div>
      </div>
      <button
          type="button"
          class="btn btn-primary btn-sm"
          data-toggle="modal"
          data-target="#addBuildingModal"
          v-on:click="newBuilding = {...defaultBuilding};newBuilding.rooms = [{}];">
        新規追加
      </button>
    </div>

    <table class="table table-striped">
      <thead>
      <tr>
        <th>#</th>
        <th>建物名</th>
        <th>階層</th>
        <th>部屋名</th>
        <th>収容人数</th>
        <th></th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="(row, index) in buildingRows" :key="row.id">
        <td>{{ index + 1 }}</td>
        <td>{{ row.buildingName }}</td>
        <td>{{ row.floorLevel }}</td>
        <td>{{ row.roomName }}</td>
        <td>{{ row.capacity }}</td>
        <td>
          <button
              type="button"
              class="btn btn-primary btn-sm ml-3"
              data-toggle="modal"
              data-target="">
            編集
          </button>
          <button
              type="button"
              class="btn btn-danger btn-sm ml-3"
              data-toggle="modal"
              data-target=""
              v-on:click="removeBuilding(row.buildingId, row.floorId, row.roomId);">
            削除
          </button>
        </td>
      </tr>
      </tbody>
    </table>

  </div>
</template>

<script>
import {ADD_BUILDING, GET_ALL_BUILDING, REMOVE_BUILDING} from "@/store/actions.type.js";
import $ from 'jquery';

export default {
  name: "Building",
  data: () => {
    const defaultBuilding = {
      name: "",
      topFloorLevel: 1,
      rooms: [{
        name: "",
        floorLevel: "",
        capacity: "",
        squareMeters: "",
      }],
      countOfRooms: 1,
    };
    return {
      newBuilding: Object.assign({}, defaultBuilding),
      defaultBuilding: Object.assign({}, defaultBuilding),
      buildingRows: [],
    };
  },
  mounted: function () {
    this.getAllBuilding();
  },
  methods: {
    addBuilding(building) {
      this.$store
          .dispatch(ADD_BUILDING, building)
          .then(() => {
            this.getAllBuilding();
            $('#closeModalButton').click();
            //this.$router.push({name: "/"});
          });
    },
    getAllBuilding() {
      this.$store
          .dispatch(GET_ALL_BUILDING)
          .then((data) => {
            this.buildingRows = [];
            data.buildings.forEach((building) => {
              building.floors.forEach((floor) => {
                floor.rooms.forEach((room) => {
                  this.buildingRows.push({
                    id: building.id + room.id,
                    buildingId: building.id,
                    floorId: floor.id,
                    roomId: room.id,
                    buildingName: building.name,
                    floorLevel: room.floorLevel,
                    roomName: room.name,
                    capacity: room.capacity,
                  })
                });
              });
            });
          });
    },
    removeBuilding(buildingId, floorId, roomId) {
      this.$store
          .dispatch(REMOVE_BUILDING, {
            buildingId: buildingId,
            floorId: floorId,
            roomId: roomId,
          })
          .then(() => {
            this.getAllBuilding();
          });
    }
  }
}
</script>

<style scoped>

</style>